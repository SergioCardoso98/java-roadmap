package intermediatemodules;

public class module {
    public static void main() {
        System.out.println("Hello from intermediate.modules");
    }
}

// This file belongs to the package:
// intermediatemodules
//
// A package is a way to organize related classes together.
//
// Packages existed BEFORE Java modules.
// They help avoid class-name conflicts and organize code.
//
// Example:
//
// intermediatemodules.module
//
// is the FULL class name.
//
// ------------------------------------------------------------
// WHAT IS MODULARITY?
// ------------------------------------------------------------
//
// Modularity means splitting an application into separate,
// independent parts called MODULES.
//
// Think of modules like:
//
// - mini applications
// - isolated components
// - protected sections of a system
//
// Java Modules were introduced in Java 9 (JPMS).
//
// Modules are ABOVE packages.
//
// Structure:
//
// MODULE
//   └── packages
//         └── classes
//
// Example:
//
// module intermediate.modules
//     └── package intermediatemodules
//            └── class module
//
// ------------------------------------------------------------
// WHY MODULES EXIST
// ------------------------------------------------------------
//
// Before Java modules:
//
// - every public class was globally accessible
// - all code shared one giant classpath
// - architecture became messy in large systems
//
// Modules solve this by:
//
// 1. Explicit dependencies
// 2. Strong encapsulation
// 3. Controlled visibility
// 4. Better architecture boundaries
//
// ------------------------------------------------------------
// HOW MODULES WORK
// ------------------------------------------------------------
//
// A module uses:
//
// module-info.java
//
// Example:
//
// module intermediate.modules {
//     exports intermediatemodules;
// }
//
// This file tells Java:
//
// 1. module name
// 2. which packages are public
// 3. what dependencies exist
//
// ------------------------------------------------------------
// exports
// ------------------------------------------------------------
//
// exports intermediatemodules;
//
// means:
//
// "Other modules may access this package."
//
// Without exports:
//
// - package stays hidden
// - classes cannot be imported outside module
//
// ------------------------------------------------------------
// requires
// ------------------------------------------------------------
//
// Another module could write:
//
// requires intermediate.modules;
//
// meaning:
//
// "I depend on this module."
//
// Java then verifies dependency relationships at compile time.
//
// ------------------------------------------------------------
// STRONG ENCAPSULATION
// ------------------------------------------------------------
//
// Before modules:
//
// public = accessible everywhere
//
// With modules:
//
// public = accessible INSIDE module
//
// exports = accessible OUTSIDE module
//
// This is one of the biggest differences.
//
// ------------------------------------------------------------
// YOUR CLASS
// ------------------------------------------------------------
//
// This class currently acts like a normal Java class.
//
// If you add:
//
// module-info.java
//
// then this class becomes part of a named Java module.
//
// ------------------------------------------------------------
// NOTE ABOUT CLASS NAME
// ------------------------------------------------------------
//
// Java class names normally start with uppercase.
//
// Better:
//
// public class Module
//
// instead of:
//
// public class module
//
// This follows Java naming conventions.
//
// ------------------------------------------------------------
// NOTE ABOUT main()
// ------------------------------------------------------------
//
// Standard Java entry point:
//
// public static void main(String[] args)
//
// Your method:
//
// public static void main()
//
// is just a normal static method,
// not the official JVM application entry point.
//