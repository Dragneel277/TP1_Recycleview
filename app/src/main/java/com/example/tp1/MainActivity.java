package com.example.tp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();

        // Initialize list with data
        loadItemList();

        ItemAdapter adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void loadItemList(){

        itemList.add(new Item("John", "Software Engineer"));
        itemList.add(new Item("Sarah", "Product Manager"));
        itemList.add(new Item("David", "UX Designer"));
        itemList.add(new Item("Lisa", "Data Scientist"));
        itemList.add(new Item("Michael", "Project Manager"));
        itemList.add(new Item("Mary", "Business Analyst"));
        itemList.add(new Item("Peter", "Software Architect"));
        itemList.add(new Item("Laura", "Marketing Manager"));
        itemList.add(new Item("Mark", "Sales Representative"));
        itemList.add(new Item("Sandra", "Customer Support"));
        itemList.add(new Item("Alex", "Network Engineer"));
        itemList.add(new Item("Emily", "Graphic Designer"));
        itemList.add(new Item("Chris", "Quality Assurance Engineer"));
        itemList.add(new Item("Daniel", "Front-end Developer"));
        itemList.add(new Item("Olivia", "HR Specialist"));
        itemList.add(new Item("Ryan", "Financial Analyst"));
        itemList.add(new Item("Sophia", "Content Writer"));
        itemList.add(new Item("Kevin", "System Administrator"));
        itemList.add(new Item("Emma", "Product Owner"));
        itemList.add(new Item("Justin", "Customer Success Manager"));
    }

    // Item class
    static class Item {

        private final String name;
        private final String jobTitle;

        Item(String name, String jobTitle) {
            this.name = name;
            this.jobTitle = jobTitle;
        }

        String getName() {
            return name;
        }

        String getJobTitle() {
            return jobTitle;
        }

    }

    // ViewHolder
    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView textName;
        private final TextView textJobTitle;

        ItemViewHolder(View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.text_name);
            textJobTitle = itemView.findViewById(R.id.text_job_title);
        }

        void setName(String name) {
            textName.setText(name);
        }

        void setJobTitle(String jobTitle) {
            textJobTitle.setText(jobTitle);
        }
    }

    // Adapter
    static class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        private final List<Item> itemList;

        ItemAdapter(List<Item> itemList) {
            this.itemList = itemList;
        }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            // Inflate the item layout
            View itemView = inflater.inflate(R.layout.item_layout, parent, false);

            // Create and return the ViewHolder
            return new ItemViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {

            // Get current item based on position
            Item item = itemList.get(position);

            // Set item views based on data
            holder.setName(item.getName());
            holder.setJobTitle(item.getJobTitle());

        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

    }
}