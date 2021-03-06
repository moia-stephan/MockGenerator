package codes.seanhenry.util.finder.methods;

import com.jetbrains.swift.psi.SwiftFunctionDeclaration;
import com.jetbrains.swift.psi.SwiftTypeDeclaration;

import java.util.List;

public interface MethodChoosingStrategy {
  List<SwiftFunctionDeclaration> chooseMethods(SwiftTypeDeclaration type);
}
