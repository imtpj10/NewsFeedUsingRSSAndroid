package com.example.opinion


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.jsoup.nodes.Document
import java.io.IOException

class MyItemRecyclerViewAdapter(
    private val mValues: List<RssItem>,
    private val mListener: RSSFragment.OnListFragmentInteractionListener?,
    private val context: FragmentActivity?
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            //val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            //mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_rss_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.titleTV?.text = item.title
        holder.pubDateTV?.text = item.pubDate
        var link = getFeaturedImageLink(item.link)
        if (link != null) {
            context?.let {
                GlideApp.with(it)
                    .load(link)
                    .into(holder.featuredImg)
            }
        }
        holder.contentTV?.text = item.description

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val titleTV: TextView? = mView.findViewById(R.id.txtTitle)
        val pubDateTV: TextView? = mView.findViewById(R.id.txtPubdate)
        val contentTV: TextView? = mView.findViewById(R.id.txtContent)
        val featuredImg: ImageView = mView.findViewById(R.id.featuredImg);


    }


    private fun getFeaturedImageLink( link: String): String? {

        var result: String? = null

        val stringBuilder = StringBuilder()
       // try {
//            val conn:Connection = Jsoup.connect(htmlText).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
//            val doc: Document = conn.get()
//            val imgs: Elements = doc.select("img")
//            for (img in imgs) {
//                var src = img.attr("src")
//                result = src
            val src : String
        if(link[8] == 't') {
            src= "https://i.postimg.cc/tJVmSG7Y/download-2.jpg"

        } else if(link[8] =='i') {
            src ="https://i.postimg.cc/pdLv0yvr/download.png"
        }else {
            if(link[12]=='t') {
                src = "https://i.postimg.cc/BbsMgPWw/The-Hindu-Logo-3.png"
            }
            else if( link[12] =='l') {

                src = "https://i.postimg.cc/y6MVVVmp/default-621.jpg"
            }else {
                src = "https://i.postimg.cc/tgW3MRz0/download-2.png"
            }

        }
        result = src

      //  }

       // } catch (e: IOException) {

     //   }
        return result

    }


}