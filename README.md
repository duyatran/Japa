Processing-inspired Java Graphics Library
==========================================


Overview
------
1. Available libraries: ACM Task force, Quickdraw, objectdraw, etc. None seem to fit our goal (see below)
2. Processing: an open-sourced programming language and IDE based on Java.
  * Provides an easy-to-use "sketchbook" API with simplified syntax.
  * Procedural programming - a few function calls can go a long way.
  * Instant graphical feedback

Objectives
------
- To teach students the desired language of the course (Python for 101 and Java for 102)
- To make programming fun and interactive through graphical feedback.
- To teach students programming concepts through graphical demonstrations.
- To teach students basic concepts in computer graphics.
- To avoid complete black-boxing (Quickdraw and Processing)
- To accommodate the transition into more complex concepts (function to
objects) and standard Java syntax.

Goal
------
To create a Java graphics library that provides Processing-like API, making it simple and intuitive to create graphical images.


Observations
--------
  1. Anti-aliasing is a shape attribute, because on one canvas, there can be
smooth _and_ non-smooth shapes.

  2. Zero stroke width: In both Java and Processing, strokeWidth(0) is different
from noStroke(). strokeWidth(0) still draws a stroke with hairline width.

  3. Stroke cap:

| Java          | Processing   |
| ------------- |:-------------:|
| CAP_BUTT      | SQUARE       |
| CAP_SQUARE    | PROJECT      |
| CAP_ROUND     | ROUND        |

  4. Arc: Different arguments in constructors

    * Processing: start - stop, clockwise

    * Java: start - extent, counter-clockwise

Issues, points of consideration, and to-do features
------
1. Constants: in Processing, constant is declared in [an interface], and
every class that uses constants implement that interface.

  **This is NOT the best practice.**

  * Type safety
  * Data encapsulation
  * Maintenance difficulty

  Read more:

  http://docs.oracle.com/javase/1.5.0/docs/guide/language/enums.html

  https://en.wikipedia.org/wiki/Constant_interface

  http://stackoverflow.com/questions/10896111/sharing-constant-strings-in-java-across-many-classes

  http://docs.oracle.com/javase/7/docs/technotes/guides/language/static-import.html

  Possible solution: Best practice would be to use enum type, but I think a class of constants (used with static import to be able to call CONSTANT and not PConstants.CONSTANT) would work as well.

  Updates:
  - A public final class is created to hold constants (with a private constructor).

2. Color:
  - In Processing, methods that take in a color parameter have six different signatures, [for example]:
    * background(int rgb)
    * background(int rgb, float alpha)
    * background(float gray)
    * background(float gray, float alpha)
    * background(float v1, float v2, float v3)
    * background(float v1, float v2, float v3, float alpha)
  - Color handling should have its own class rather than become a shape
  attribute or be implemented in MyCanvas. Color class will have these six
  constructors, and return a Java Color object.
  - In Processing, color ranges and modes are independent:

    > colorMode(RGB, 100, 100, 100);

    > // some code

    > colorMode(HSB);

    > // now, the color mode is changed to HSB, but the range is still
    (100, 100, 100)

  Updates:
  - A MyColor class is created to hold the colorMode and provide color calculation methods.
  - To-do: Default ranges and hack mode

3. size(): size() must be run first to create a canvas. Right now, multiple calls to size() will create many windows. This is not the case in Processing, where the last call to size() will determine the actual size of the canvas.

  * Should we allow more than one call to size()?
  * Should we allow resizing? Processing [does not].

  Updates:
  - No and no.
  - branch sizemethod

4. Shape attributes: A ShapeAttributes object currently holds too much
 information. Right now, a line's ShapeAttributes already have two unnecessary variables, fill() and fillColor(). How can we efficiently assign relevant attributes to a shape depending on its type?

5. Float vs. Double: Processing uses Float, possibly because there is no need for double precision. Using float in Java, however, is inconvenient, because students would need to add the character 'f' after every decimal number.

Updates: For convenience's sake, all public methods accept double parameters, and MyCanvas methods cast them to appropriate types.

6. Shape mode: Processing provides many modes to draw rectangles and ellipses through rectMode() and ellipseMode().

Updates: branch shapeMode

Further to-do list and ideas
-----------------
1. Documentation
2. Exceptions and error handling
3. Text drawing
4. Image input/output
5. Interaction
6. Composition
7. Animation
8. Responsive GUI to set variables
9. Pan-and-zoom canvas

[an interface]: https://github.com/processing/processing/blob/bd7638ec0acf3e4ee911fcf72405942517756775/core/src/processing/core/PConstants.java
[does not]: http://stackoverflow.com/questions/17081359/how-to-automatically-let-a-sketch-done-in-processing-resize-when-you-resize-a-r
[for example]: https://processing.org/reference/background_.html
