package com.jmgarzo.newratescar;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jmgarzo.newratescar.objects.Operation;

import java.util.ArrayList;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * A placeholder fragment containing a simple view.
 */
public class MaintenanceDetailFragment extends Fragment {

    private TextView operationTitle;

    private ImageView mAddOperationImage;

    private ArrayList<Operation> operations;


    //New Operation
    private TextInputLayout mNewTextLayoutOperationName;
    private EditText myNewOperationName;
    private TextInputLayout mNewTextLayoutDescription;
    private EditText myNewOperationDescription;


    public MaintenanceDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_maintenance_detail, container, false);
        operations = new ArrayList<>();

        operationTitle = (TextView) view.findViewById(R.id.operation_title);
        operationTitle.setText(R.string.operation_title);

        addNewOperation(view);



        mAddOperationImage.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View v) {
                                                      if (operations.size() > 0) {
                                                          if (null != myNewOperationName && !myNewOperationName.getText().toString().isEmpty()) {
                                                              //get values
                                                              Operation operation = new Operation(myNewOperationName.getText().toString(), myNewOperationDescription.getText().toString());
                                                              operations.add(operation);
                                                              //new operation
                                                              addNewOperation(view);
                                                          }
                                                      } else {

                                                          addNewOperation(view);
                                                      }

                                                  }
                                              }

        );

        return view;
    }


    private void addNewOperation(View view) {



        LinearLayout parent = (LinearLayout) view.findViewById(R.id.layout_maintenance_operation);

        mNewTextLayoutOperationName = new TextInputLayout(getContext());
        myNewOperationName = new EditText(getContext());
        myNewOperationName.setHint(R.string.maintenance_operation_name);
        mNewTextLayoutOperationName.addView(myNewOperationName);

        LinearLayout layoutDescription = new LinearLayout(getContext());
        layoutDescription.setOrientation(LinearLayout.HORIZONTAL);
        layoutDescription.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT));

        mNewTextLayoutDescription = new TextInputLayout(getContext());
        mNewTextLayoutDescription.setLayoutParams(new TextInputLayout.LayoutParams(0,WRAP_CONTENT,3));
        myNewOperationDescription = new EditText(getContext());
        myNewOperationDescription.setHint(R.string.maintenance_operation_description);
        mNewTextLayoutDescription.addView(myNewOperationDescription);

        layoutDescription.addView(mNewTextLayoutDescription);

        mAddOperationImage = new ImageView(getContext());
        mAddOperationImage.setImageResource(R.drawable.ic_add_black_48dp);
        mAddOperationImage.setLayoutParams(new LinearLayout.LayoutParams(0,WRAP_CONTENT,1));
        layoutDescription.addView(mAddOperationImage);

        parent.addView(mNewTextLayoutOperationName);
        parent.addView(layoutDescription);


    }
}
