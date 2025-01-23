# RecyclerView, ViewHolder

`kotlin.Any -> android.view.View -> android.view.ViewGroup -> androidx.recyclerview.widget.RecyclerView`

    class RecyclerView : ViewGroup, ScrollingView, NestedScrollingChild2, NestedScrollingChild3

`androidx.recyclerview.widget.RecyclerView.ViewHolder`

    // public constructor
    ViewHolder(itemView: View)

## RecyclerView

Can be used to create a list of lists where the outer list scrolls vertically and the inner lists croll horizontally

Interface for user clicks: `View.onClickListener`

## ViewHolder 

In Adapter when using RecyclerView: Save ID each view in list

**Adapter**

RecyclerView need an Adapter to create new ViewHolders and bind data to them

