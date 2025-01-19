# List-Based Widgets
Lists, Grids, and Scroll Views

`Raw Data -> Data Adapter -> Formatted & Bound Data -> ListView`

## ListViews
The most common element used to display data supplied by a data adapter

### ArrayAdapter

`java.lang.Object -> android.widget.BaseAdapter -> android.widget.ArrayAdapter<T>`

    val adapter: ArrayAdapter<String> = ArrayAdapter(
        this, android.R.layout.simple_list_item_1, items
    )

    // constructor
    ArrayAdapter(Context context, int resource, T[] objects)

### ListView

    val listView: ListView = findViewById(R.id.list_view)

    listView.adapter = adapter
    listView.setOnItemClickListener { _, _, i, _ ->
        txtMsg.text = "Position: $i\nData: ${items[i]}"
    }

    // form
    listView.setOnItemClickListener { parent, view, position, id -> }

### notifyDatasetChanged()

    