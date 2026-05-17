module intermediate.modules {

    // This declares a Java Module named "intermediate.modules".
    //
    // A module is a higher-level container than a package.
    // It groups related packages together and controls what is visible
    // to other parts of an application.

    // Before Java 9, all code lived on the classpath:
    // - everything was globally visible if it was public
    // - there was no strict boundary between libraries
    //
    // With modules (JPMS - Java Platform Module System),
    // Java enforces stronger structure and encapsulation.

    // ---------------------------------------------------------
    // exports
    // ---------------------------------------------------------
    //
    // This line:
    //
    // exports intermediatemodules;
    //
    // means:
    //
    // "The package intermediatemodules is visible to other modules."
    //
    // Only exported packages can be accessed from outside this module.
    //
    // Even if a class is public, it is NOT accessible externally
    // unless its package is exported here.

    exports intermediatemodules;

    // ---------------------------------------------------------
    // WHAT THIS MODULE DOES
    // ---------------------------------------------------------
    //
    // This module:
    // 1. Defines a boundary for your code
    // 2. Exposes only selected packages (via exports)
    // 3. Hides all other internal packages automatically
    //
    // Any package not listed in "exports" remains internal
    // and cannot be accessed from outside this module.

    // ---------------------------------------------------------
    // FUTURE EXTENSIONS
    // ---------------------------------------------------------
    //
    // You can also add:
    //
    // requires other.module;
    //
    // to depend on another module.
    //
    // And:
    //
    // uses ServiceInterface;
    // provides ServiceInterface with Implementation;
    //
    // for plugin-style architectures (ServiceLoader).
}