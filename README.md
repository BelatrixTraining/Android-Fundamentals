# Android-Fundamentals
Android Fundamentals (20h)
  
## User Interface(4h)

 - Layout y Widgets (2h)
 
 - Eventos de Usuario (2h)

## Layouts y Widgets

- Fundamentos

- Widgets

- Layouts

- Ejemplos


### Fundamentos

- Estructura de un elemento XML :
  
```xml
    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent"
        android:layout_height="match_parent" android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        android:paddingBottom="@dimen/activity_vertical_margin">
    
        <TextView android:text="Hello World!" android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
    </RelativeLayout>
```

- ID :
  
```xml
      android:id="@+id/img"
```

```xml
      <TextView
            android:id="@+id/txtImg"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Medium Text"
            android:textAppearance="?android:attr/textAppearanceMedium" />
```
    
- Atributos :
    
```xml
        android:layout_width="300dp"
```
    
- En el código podemos invocar a los elementos XML de la siguiente manera :
  
```xml
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
      }
```
    
```java
     private ImageView img;
     private Button btnImg;
     private TextView txtImg;

     img= (ImageView)findViewById(R.id.img);
     btnImg= (Button)findViewById(R.id.butImg);
     txtImg = (TextView)findViewById(R.id.txtImg);
```

- Módelo de Caja :

Margin

<img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/boxmodel_margin.png" height="480">

Padding

<img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/boxmodel_padding.png" height="480">

### Widgets

### Layouts

  
- LinearLayout
    
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/linearlayout.png" height="480">

- RelativeLayout
    
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/relativelayout.png" height="480">
         
- Listview, GridView , RecyclerView
    
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/listview.png" height="480">
    
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/gridview.png" height="480">


### Ejemplos

- LinearLayout
    
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/linearlayout_sample.png" height="480">
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/linearlayout_horz_sample.png" height="480">
    
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/linearlayout_weight_ver_sample.png" height="480">
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/linearlayout_weight_hor_sample.png" height="480">
   
- RelativeLayout 
 
- Ejemplos de maquetación
    
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/login_sample.png" height="480">
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/login_sample_xml.png" height="480">

    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/layout_sample1.png" height="480">
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/layout_sample1.png" height="480">

    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/layout_sample3.png" height="480">
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/layout_sample4.png" height="480">

    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/layout_sample5.png" height="480">
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/layout_sample6.png" height="480">

    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/layout_sample7.png" height="480">
    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/layout_sample8.png" height="480">

    <img src="https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4/images/layout_sample8.png" height="480">


Referencias :
   - [https://developer.android.com/guide/topics/ui/index.html](https://developer.android.com/guide/topics/ui/index.html)
   
   - [https://developer.android.com/training/basics/firstapp/building-ui.html](https://developer.android.com/training/basics/firstapp/building-ui.html)
   
   - [https://developer.android.com/design/index.html](https://developer.android.com/design/index.html)
   
   - [https://developer.android.com/guide/topics/ui/declaring-layout.html](https://developer.android.com/guide/topics/ui/declaring-layout.html)
   
   - [http://android.inspired-ui.com/](http://android.inspired-ui.com/)
    
