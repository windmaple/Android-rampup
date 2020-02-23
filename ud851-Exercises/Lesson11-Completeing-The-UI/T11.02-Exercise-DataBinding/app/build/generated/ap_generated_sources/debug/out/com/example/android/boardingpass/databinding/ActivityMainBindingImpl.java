package com.example.android.boardingpass.databinding;
import com.example.android.boardingpass.R;
import com.example.android.boardingpass.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textViewPassengerLabel, 1);
        sViewsWithIds.put(R.id.textViewPassengerName, 2);
        sViewsWithIds.put(R.id.leftRectangle, 3);
        sViewsWithIds.put(R.id.divider, 4);
        sViewsWithIds.put(R.id.rightRectangle, 5);
        sViewsWithIds.put(R.id.textViewOriginAirport, 6);
        sViewsWithIds.put(R.id.textViewDestinationAirport, 7);
        sViewsWithIds.put(R.id.imagePlane, 8);
        sViewsWithIds.put(R.id.textViewFlightCode, 9);
        sViewsWithIds.put(R.id.textViewBoardingTimeLabel, 10);
        sViewsWithIds.put(R.id.textViewBoardingTime, 11);
        sViewsWithIds.put(R.id.textViewDepartureTimeLabel, 12);
        sViewsWithIds.put(R.id.textViewDepartureTime, 13);
        sViewsWithIds.put(R.id.textViewBoardingInTimeLabel, 14);
        sViewsWithIds.put(R.id.textViewBoardingInCountdown, 15);
        sViewsWithIds.put(R.id.textViewArrivalTimeLabel, 16);
        sViewsWithIds.put(R.id.textViewArrivalTime, 17);
        sViewsWithIds.put(R.id.tableHeaderImage, 18);
        sViewsWithIds.put(R.id.tableImage, 19);
        sViewsWithIds.put(R.id.textViewTerminalLabel, 20);
        sViewsWithIds.put(R.id.textViewGateLabel, 21);
        sViewsWithIds.put(R.id.textViewSeatLabel, 22);
        sViewsWithIds.put(R.id.textViewTerminal, 23);
        sViewsWithIds.put(R.id.textViewGate, 24);
        sViewsWithIds.put(R.id.textViewSeat, 25);
        sViewsWithIds.put(R.id.barcode, 26);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 27, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[26]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ScrollView) bindings[0]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[20]
            );
        this.scroll.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}