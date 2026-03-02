Java Package:
Java Packages are systematic way of storing related files in a single folder,
it helps in organizing the code and avoid any confusion/conflicts between codes.

like storing a car's engine modules in a engine folder, its body parts in body..

Car->Engine->start : package car.engine;
Car->body->door : package car.body;

Now we can also import this package into another let say i want to import the body 
package into the engine then :
packae car.engine;
import car.body;

*import statement is written after the declaration of the package and befre the class declaration.


Access Modifiers:
These are the keywords used for accessibility and visibility of class, variable, interfaces, methods
- private  : it can be access only in same class
- default (no modifier) : it can be access only in same package : package-private
- protected : it can be access only in same package, different package - subclass not in class of different package
- public : it can be access from any where 

| Access Modifier | Same Class | Same Package | Subclass (Different Package) | Different Package |
|-----------------|------------|--------------|------------------------------|-------------------|
| private         | Yes        | No           | No                           | No                |
| default         | Yes        | Yes          | No                           | No                |
| protected       | Yes        | Yes          | Yes                          | No                |
| public          | Yes        | Yes          | Yes                          | Yes               |


Encapsulation:
Encapsulation is the process of wrapping/bundling the data and method in single class and 
restricting the access to the data from outside of the class and only allowing the access through public method.
it can be achieved by using access modifier, getter and setter methods.

