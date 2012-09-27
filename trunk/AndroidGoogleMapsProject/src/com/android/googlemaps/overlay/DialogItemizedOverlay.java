package com.android.googlemaps.overlay;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class DialogItemizedOverlay extends ItemizedOverlay{
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	private String msg;
    Context mContext;
    public DialogItemizedOverlay(Context context,Drawable defaultMarker, String msg) {
        super(boundCenterBottom(defaultMarker));
        mContext = context;
        this.msg = msg;
    }
    @Override
    protected boolean onTap(int index) {
        OverlayItem item =mOverlays.get(index);
        AlertDialog.Builder dialog= new AlertDialog.Builder(mContext);
        dialog.setTitle(item.getTitle());
        dialog.setMessage(this.msg);
        try{
        dialog.show();
        }catch(Exception el){
        	
        }
        return super.onTap(index);

}

    public void addOverlay(OverlayItem overlay) {
        mOverlays.add(overlay);
        populate();
    }

    @Override
    protected OverlayItem createItem(int i) {
        return mOverlays.get(i);
    }

    @Override
    public int size() {
        return mOverlays.size();

    }

}
