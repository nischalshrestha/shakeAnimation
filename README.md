# Shake Animation

This is a shake animation, specifically for text fields when input is incorrect, that also performs a pulse animation with the color of your choice.

## Demo:

<img src="http://zippy.gfycat.com/DentalFrequentBlueandgoldmackaw.gif"/>

<a href="https://www.youtube.com/watch?v=yuChiHIvfKw" target="_blank">Youtube Video<br/> <img src="http://img.youtube.com/vi/yuChiHIvfKw/0.jpg" 
alt="Shake Animation demo" border="10" /></a>

## Code:

```java
EditText textField = (EditText) findViewById(R.id.editText);
Shaker shaker = new Shaker(textField, -15, 15, GREY, Color.RED);
//Wrap this with the appropriate condition
shaker.shake();
```

## Future plans:

Currently, this performs shake animation based on set properties for the 3 animators, encapsulated in Shaker. I arrived at the default values simply by tweaking and observing what felt right. Another property that I plan to add is rotation to give it a jiggling effect.

For increased customizability, I'm considering making it possible to either pass in the shake and color animators in a separate constructor, and/or allow tweaking via methods:

```java
//Constructor
Shaker shaker = new Shaker(textField, shakeAnimator, colorAnimator);

//number of 'shakes'
shaker.setShakeCount(5);     
//displacement for the shake
shaker.setShakeDistance(20); 
//duration of the color animation
shaker.setColorAnimationDuration(150); 
//angle for rotation effect, if set
shaker.setRotationAngle(10);

//etc...
```
