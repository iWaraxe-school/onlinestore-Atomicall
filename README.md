# 4. Collections
## Materials

[Collections](https://docs.oracle.com/javase/tutorial/collections/index.html)

[Lecture 9](https://coherentsolutions.sharepoint.com/sites/training-center/_layouts/15/WopiFrame.aspx?sourcedoc=%7bEF21525C-52B3-45A0-8E14-71BFC9BAB74E%7d&file=L9.pptx&action=default)

[XML](https://en.wikipedia.org/wiki/XML)

[XML processing](https://docs.oracle.com/javase/tutorial/jaxp/)

## VideoLectures
- [Collections, Lists, Sets, Unmodifiable Lists and Sets](https://drive.google.com/file/d/1uC3XlEtUI9rk6bYx-OBsF9PFcRfZjxDv/view?usp=sharing)
- [Lists, Sets, Maps, Unmodifiable Maps](https://drive.google.com/file/d/1wH8SLzZ\_tl97rk9AAc10uWf11oOWrcxQ/view?usp=sharing)
- [Generics (part 1)](https://drive.google.com/file/d/1k4DkEOh40x6vqLu9qVQo7O19tRkElzMd/view?usp=sharing)
- [Generics (part 2)](https://drive.google.com/file/d/1zJxJqgGjLE37Rdaf-2iUAf5FXcvcGY8Y/view?usp=sharing)
- [Functional Interfaces, Introduction to lambdas](https://drive.google.com/file/d/1HFDFxDMCyBZeSAR8wGp2WIZoFlvHw1g4/view?usp=sharing)
- [Lambdas](https://drive.google.com/file/d/1Oak\_SFxlFczz\_gBItECTDEiAyp7awzLC/view?usp=sharing)
- [Stream API](https://drive.google.com/file/d/1YPm2XcxsVy3zDC6kkDBu16Ca7V5duhJn/view?usp=sharing)
- [PrimitiveStream, Optional](https://drive.google.com/file/d/1NuD7hHJmyKlPSK3o2Ww4RuWuc7fYT\_nX/view?usp=sharing)

## Task #4

Starting extend our store. Please append ability user to interact with our store, while sending commands through read stream.
Add support of such commands: 
- `sort` - products from store according config. In resources folder create xml config file like
```
xml
<sort>
    <name>asc</name>
    <price>asc</price>
    <rate>desc</rate>
</sort>
```
Config file can contains from 1 to N fields. Sort should be done using `Comparator`. Sort and print should not modify
 default store product lists and their order.
- `top` - print top 5 products of whole store sorted via price desc
- `quit` - exit app
