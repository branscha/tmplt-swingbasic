SwingBasic Template
===================

Parent template: -

Dependencies:
- JavaHelp artefact.

Description: A basic Swing application consisting of (1) a frame, (2) a menu bar and (3) a help system.
             Help is fundamental part of the template, it should not be ignored.
             Published under MIT License.

Characteristics
- Parts of the GUI are stored in a global data structure 'viewModel'. Making parts of the GUI global makes
  it easier to construct the GUI in different places, it produces code that is more elegant than passing
  the information around in parameters.
- The domain model is explicitly missing from the template. Parts of it could be kept in a global 'domainModel'
  data structure similar to the GUI approach. Mediators should be created to bind the domain model objects to
  the view models which are in turn part of the Swing interface.
- Library naming conventions (it is not a strict system, just a convenience):
  * 'action.someaction' to register Swing actions.
  * 'string.somename' to register string resources, 'title', 'version', ...
  * 'image.crab' to store images.
  * 'window.frame' for the main frame.
  * 'menu' for the menu bar.
  * 'menu.file', 'menu.help' for the sub menus and so on.

JavaHelp
 - Java Help contains *lots* of features, 'full text search' view is not included in this example because
   it requires an extra step to create the database, it would have complicated the pom.xml since there
   are no maven plugins at this point in time to do this automatically. It is not so difficult to do it
   manually.
   * http://javahelp.java.net/
   * Procedure:
     1. Make the help directory the current directory.
     2. Run the 'jhindexer' tool
        OR
        run the 'com.sun.java.help.search.Indexer' class which is included in the javahelp jar.
     3. Uncomment the search view in 'apphelp.hs' to enable it.
     4. Do a 'mvn clean install' in order to copy the generated resources to the output directory.
        If you don't do this step, the generated files will not be picked up by the search view.

Build instructions:
 * It is a Maven project, the dependencies are in the POM and the required JavaHelp jar is in the public repository.
 * The entry point is the 'com.sdicons.app.App' class which contains the main() static method.

References
- Icons
  * http://www.iconfinder.com/
  * http://www.famfamfam.com/lab/icons/silk/
  * http://p.yusukekamiyamane.com/
  * http://commons.wikimedia.org/wiki/Crystal_Clear