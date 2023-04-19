# some documentation for this program

## below here will be what we want to do / change
- [] refactor loading of the product data out into a new file
  - [] see Menu.java
- [] generate / improve the class diagram for this project
- [] maybe change some of the method names
- [] write some tests; more specifically for:
  - [] for example for basket class
- [] generate a jar file + executable shell script to make it easy to run
- [] document more (also how to run the program from the jar file)
-

## below here will be what we have already done

## translations for some of the names:
 - vidmot: more or less frontend/inteface
 - vinnsla: logic

## design pattern:
We use the Observer behavioural pattern, by using listeners and event handlers. This can be seen in several places, usually to make the interface reflect changes as they happen
- Basket basket in OrderingController is observed, and ListView<Product> fxBasket is updated
- the same happens in TransactionController
- in Basket, there is a listener which observes the ObservableList<Product> from Menu and updates IntegerProperty totalPrice accordingly
- event handlers i.e. in OrderingController and TransactionController observe objects in the GUI and react when they are interacted with
- BooleanProperty loggedIn in OrderingController is observed, and the user interface is updated
