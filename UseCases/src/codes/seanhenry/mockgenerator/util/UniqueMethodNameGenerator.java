package codes.seanhenry.mockgenerator.util;

import java.util.*;

public class UniqueMethodNameGenerator {

  private final HashMap<String, String> uniqueMethodName = new HashMap<>();
  private final Set<MethodModel> duplicateMethodModels = new HashSet<>();

  public UniqueMethodNameGenerator(MethodModel... methodModels) {
    this(Arrays.asList(methodModels));
  }

  public UniqueMethodNameGenerator(List<MethodModel> methodModels) {
    duplicateMethodModels.addAll(methodModels);
  }

  public void generateMethodNames() {
    while (!duplicateMethodModels.isEmpty()) {
      processDuplicates();
    }
  }

  private void processDuplicates() {
    HashMap<String, List<MethodModel>> nameBuckets = moveDuplicatesToNameBuckets();
    for (String name : new HashSet<>(nameBuckets.keySet())) {
      List<MethodModel> models = nameBuckets.get(name);
      commitUniqueModels(name, models);
    }
  }

  private void commitUniqueModels(String name, List<MethodModel> models) {
    if (models.size() == 1) {
      commitModel(name, models.get(0));
    } else {
      sortBySimplest(models);
      MethodModel simplestModel = models.get(0);
      if (isUniquelySimple(models)) {
        commitModel(name, simplestModel);
      }
      commitModelsThatCannotGetMoreComplex(models, name);
    }
  }

  private void commitModelsThatCannotGetMoreComplex(List<MethodModel> models, String name) {
    for (MethodModel model : models) {
      if (canModelGetMoreComplex(model)) {
        commitModel(name, model);
      }
    }
  }

  private static boolean canModelGetMoreComplex(MethodModel model) {
    return model.peekNextPreferredName() == null;
  }

  private static boolean isUniquelySimple(List<MethodModel> models) {
    int simplestParamCount = models.get(0).getParameterCount();
    int nextSimplestParamCount = models.get(1).getParameterCount();
    return simplestParamCount < nextSimplestParamCount;
  }

  private void commitModel(String name, MethodModel simplestModel) {
    duplicateMethodModels.remove(simplestModel);
    uniqueMethodName.put(simplestModel.getId(), strip(name));
  }

  private String strip(String name) {
    return name.replaceAll("\\W", "");
  }

  private static void sortBySimplest(List<MethodModel> models) {
    boolean swapped;
    do {
      swapped = false;
      for (int i = 1; i < models.size(); i++) {
        if (models.get(i).getParameterCount() < models.get(i - 1).getParameterCount()) {
          MethodModel m = models.get(i - 1);
          models.set(i - 1, models.get(i));
          models.set(i, m);
          swapped = true;
        }
      }
    } while (swapped);
  }

  private HashMap<String, List<MethodModel>> moveDuplicatesToNameBuckets() {
    HashMap<String, List<MethodModel>> nameBuckets = new HashMap<>();
    for (MethodModel model : duplicateMethodModels) {
      String name = model.nextPreferredName();
      List<MethodModel> models = getModels(nameBuckets, name);
      models.add(model);
      nameBuckets.put(name, models);
    }
    return nameBuckets;
  }

  private static List<MethodModel> getModels(HashMap<String, List<MethodModel>> nameBuckets, String name) {
    List<MethodModel> models = nameBuckets.get(name);
    if (models == null) {
      models = new ArrayList<>();
    }
    return models;
  }

  public String getMethodName(String id) {
    return uniqueMethodName.get(id);
  }
}

