package com.example.a3rdasignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3rdasignment.Model.Student;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Stu_Adapter extends RecyclerView.Adapter<Stu_Adapter.ContactsViewHolder>{

    Context context;
    List<Student> studentList;

    public Stu_Adapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_stu,parent,false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, final int position) {
        final Student student= studentList.get(position);

        holder.Name.setText(student.getName());
        holder.Address.setText(student.getAddress());
        holder.Age.setText(student.getAge());
        holder.Gender.setText(student.getGender());
        holder.imgProfile.setImageResource(student.getImage());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.remove(position);
                notifyItemRemoved(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder{

        ImageView imgProfile;
        TextView Name,Address,Age,Gender;
        ImageView delete;
        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
imgProfile=itemView.findViewById(R.id.Profile);
            Name = itemView.findViewById(R.id.fullName);
            Address = itemView.findViewById(R.id.Address);
            Age = itemView.findViewById(R.id.Age);
            Gender=itemView.findViewById(R.id.Sex);
            delete = itemView.findViewById(R.id.del);
        }
    }
}
