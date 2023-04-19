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
We use the Observer behavioural pattern, by using listeners, event handlers and bindings. This can be seen in several places, usually to make the interface reflect changes as they happen

#Listeners
The object that the listener is put on is observed, and is therefore called an observable.
The object that is updated within the listener is observing, and is therefore called an observer.
- Listener on getProducts() of Basket basket in OrderingController, which returns an ObservableList<Product>, and ListView<Product> fxBasket is updated
- Listener on getProducts() of Basket basket in TransactionController, ListView<Product> fxBasket is updated
- Listener on ObservableList<Product> (from getProducts()) in Basket, which is inherited from Menu, and IntegerProperty totalPrice in Basket is updated
- Listener on BooleanProperty loggedIn in OrderingController, text on the fxLoginButton is updated

#Bindings
When using single-direction bindings, the observer is bound to the observable, usually with observer.bind(observable)
- The text of fxTotalPrice (in the interface) is bound to the totalPriceProperty of the basket instance, both in OrderingController
- The Button fxPayButton in OrderingController is bound to the totalPriceProperty of the basket in Ordering, to disable it
- The Button fxLoginButton in OrderingController is bound to BooleanProperty loggedIn in OrderingController, to disable it
- The ok button in CustomerDialog is bound to the content of the textfields in the interface (to disable it)
- The nameProperty and addressProperty of the customer in CustomerDialog are bound to their respective textfields in the interface
- The text of the label fxName in TransactionController is bound to the nameProperty of the customer field in OrderingController
- The text of the label fxAddress in TransactionController is bound to the addressProperty of the customer field in OrderingController
- getProducts() of the basket field in TransactionController, which returns an ObservableList<Product>, is bound to getProducts() of the basket field in OrderingController
- The text of the label fxTotalPrice in TransactionController is bound to the totalPriceProperty of the basket field in TransactionController

#Handlers
Event handlers i.e. in OrderingController and TransactionController observe objects in the GUI and react when they are interacted with
The object in the interface which the handler is put on is the observable
The observable is presumably within the code of the handler, whatever is updated
