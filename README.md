# Android-Fundamentals
Android Fundamentals (20h)
    
RecyclerView y Adapters (4h)
 
   * Basic Adapters
    
   * Custom Adapters
    

ListView and GridView
    
![](https://developer.android.com/images/ui/listview.png) ![](https://developer.android.com/images/ui/gridview.png)
          

Design 
    
* Galleries [http://android.inspired-ui.com/tagged/galleries](http://android.inspired-ui.com/tagged/galleries)
        
* Lists [http://android.inspired-ui.com/tagged/lists](http://android.inspired-ui.com/tagged/lists)
        

Components
    
   * DataSource
        
   * Adapter
        
   * View
        
![](https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson5-2/images/androidAdapter.png)


Adapter & Custom Adapters
 
  - Adapters
  
      * Cursor Adapter
       
      * Array Adapter
        
      * Base Adapter
            
  - Structure
    
      BaseAdapter [link](https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson5-2/ADAPTER.md)
        
  - Steps 
    
    * 1. Create model (Entity Class)
    
    * 2. Get Data source (List , ArrayList)
    
    * 3. Create row.xml
    
    * 4. Create adapter
    
    * 5. Set Adapter to View (ListView, GridView)


Patrón ViewHolder
 
    ```
        class ViewHolder {
            ImageView icon;
            TextView title;
            TextView subtitle;
        }
    ```
    ```
        // Inside the adapter
        public void getView(int position, View convertView, ViewGroup parent) {
            // if convertView is null, the view is newly inflated.
            // else, re-assign new values.
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.row, null);
                // Set up the ViewHolder.
                holder = new ViewHolder();
                holder.icon = (ImageView) findViewById(R.id.icon);
                holder.title = (TextView) findViewById(R.id.title);
                holder.subtitle = (TextView) findViewById(R.id.subtitle);
                // Store the holder with the view.
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            // Assign values
            holder.icon.setImageDrawable(some_image);
            holder.title.setText(some_text);
            holder.subtitle.setText(some_text);
        }
    ```


Eventos
    
    - setOnItemClickListener
    
        ```
           lviCheeses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    String value= String.valueOf(adapterView.getAdapter().getItem(position));
                    showItem(value);
                }
           });
        ```


Referencias :

   - [https://developer.android.com/guide/topics/ui/layout/listview.html](https://developer.android.com/guide/topics/ui/layout/listview.html)
   
   - [https://developer.android.com/guide/topics/ui/layout/gridview.html](https://developer.android.com/guide/topics/ui/layout/gridview.html)
   
   - [https://developer.android.com/guide/topics/ui/controls/spinner.html](https://developer.android.com/guide/topics/ui/controls/spinner.html)
   
   - [https://developer.android.com/guide/topics/ui/declaring-layout.html](https://developer.android.com/guide/topics/ui/declaring-layout.html)
   
   - [https://developer.android.com/training/improving-layouts/smooth-scrolling.html](https://developer.android.com/training/improving-layouts/smooth-scrolling.html)
   
   - [https://sriramramani.wordpress.com/2012/07/25/infamous-viewholder-pattern/](https://sriramramani.wordpress.com/2012/07/25/infamous-viewholder-pattern/)
