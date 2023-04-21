# some documentation for this program

## translations for some of the names:
 - vidmot: more or less frontend/inteface
 - vinnsla: logic

## design pattern:
We use the Observer behavioural pattern, by using listeners, event handlers and bindings. This can be seen in several places, usually to make the interface reflect changes as they happen

### Listeners
The object that the listener is put on is observed, and is therefore called an observable.
The object that is updated within the listener is observing, and is therefore called an observer.
There are listeners on the products in the basket in several places, which updates the corresponding ListView.
There is also a listener on a BooleanProperty to update the text on the login button

### Bindings
When using single-direction bindings, the observer is bound to the observable, usually with observer.bind(observable)
Many textfields and labels are bound to properties from Basket and Customer. Some buttons are also bound to properties
to disable them in certain situations. The products in the basket in TransactionController are bound to the products
in the basket in OrderingController. In one case, the properties of Customer are bound to textfields in the interface

### Handlers
Event handlers i.e. in OrderingController and TransactionController observe objects in the GUI and react when they are interacted with
The object in the interface which the handler is put on is the observable
The observable is presumably within the code of the handler, whatever is updated
