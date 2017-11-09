package com.example.imac.checkbox;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CheckBox chk_select_all;
    private boolean isEdit = true;
    private Toolbar toolbar;
    private ImageButton imgEdit, btn_delete_all, imgClose, imgBack;

    private ArrayList<Model> item_list = new ArrayList<>();
    private ModelAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControls();
    }

    private void initControls() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        chk_select_all = findViewById(R.id.chk_select_all);
        btn_delete_all = findViewById(R.id.btn_delete_all);
        imgEdit = findViewById(R.id.imgEdit);
        imgBack = findViewById(R.id.imgBack);
        imgClose = findViewById(R.id.imgClose);
        chk_select_all.setVisibility(View.GONE);
        btn_delete_all.setVisibility(View.GONE);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        item_list.add(new Model("Marsh Mallow", "false", "false"));
        item_list.add(new Model("Nougat", "false", "false"));


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ModelAdapter(item_list);
        recyclerView.setAdapter(mAdapter);

        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEdit) {
                    chk_select_all.setVisibility(View.VISIBLE);
                    btn_delete_all.setVisibility(View.VISIBLE);
                    imgEdit.setVisibility(View.GONE);
                    imgClose.setVisibility(View.VISIBLE);
                    imgBack.setVisibility(View.GONE);
                    isEdit = false;

                    for (Model model : item_list) {
                        model.setShowed("true");
                    }
                    mAdapter.notifyDataSetChanged();
                } else {
                    chk_select_all.setVisibility(View.GONE);
                    btn_delete_all.setVisibility(View.GONE);
                    imgEdit.setVisibility(View.VISIBLE);
                    imgClose.setVisibility(View.GONE);
                    imgBack.setVisibility(View.VISIBLE);
                }
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chk_select_all.setVisibility(View.GONE);
                btn_delete_all.setVisibility(View.GONE);
                imgEdit.setVisibility(View.VISIBLE);
                imgClose.setVisibility(View.GONE);
                imgBack.setVisibility(View.VISIBLE);
                isEdit = true;
                for (Model model : item_list) {
                    model.setShowed("false");
                }
                mAdapter.notifyDataSetChanged();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        chk_select_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_select_all.isChecked()) {

                    for (Model model : item_list) {
                        model.setSelected("true");
                    }
                } else {

                    for (Model model : item_list) {
                        model.setSelected("false");
                    }
                }

                mAdapter.notifyDataSetChanged();
            }
        });

        btn_delete_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (chk_select_all.isChecked()) {
                    item_list.clear();
                    mAdapter.notifyDataSetChanged();
                    chk_select_all.setChecked(false);
                } else {
                    Snackbar.make(v, "Please click on select all check box, to delete all items.", Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }

}
