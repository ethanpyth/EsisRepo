package org.esisalama.esisrepo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import esisRepo.DAO.UserDAO;
import esisRepo.DAO.WorkDAO;
import esisRepo.Database.AppDatabase;
import esisRepo.UserService;
import esisRepo.entity.Repos;
import esisRepo.entity.User;
import esisRepo.entity.Work;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    private TextView nameText;
    private TextView matriculeText;
    private TextView workList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *_blank
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        MenuHost menuHost = requireActivity();
        menuHost.addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.menu_profile, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                if(R.id.modifyProfile == menuItem.getItemId()){
                    Intent modifyProfileIntent = new Intent(getActivity(), ModifyProfileActivity.class);
                    startActivity(modifyProfileIntent);
                }
                return true;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        initComponent(view);
        getRequest();
        return view;
    }


    private void savedUser(String workName, int workId, int userId, String userName){
        Work work = new Work(workName, workId, userId);
        User user = new User(userName, userId);
        AppDatabase db = Room.databaseBuilder(requireActivity(), AppDatabase.class, "db").allowMainThreadQueries().build();
        WorkDAO workDAO = db.workDAO();
        UserDAO userDAO = db.userDAO();
        userDAO.insert(user);
        workDAO.insert(work);
        show(workDAO, userDAO, userId);
    }

    private void getRequest(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build();
        UserService userService = retrofit.create(UserService.class);

        Call<List<Repos>> callback = userService.getUser();
        callback.enqueue(new Callback<List<Repos>>() {
            @Override
            public void onResponse(@NonNull Call<List<Repos>> call, @NonNull Response<List<Repos>> response) {
                if (response.isSuccessful()){
                    List<Repos> work = response.body();
                    if (work == null){
                        Toast.makeText(
                                requireActivity(),
                                "Cet utilisateur n'éxiste pas",
                                Toast.LENGTH_SHORT
                        ).show();
                    } else {
                        for (Repos e: work) {
                            Repos repos = new Repos(e.id, e.name, e.owner);

                            savedUser(repos.name, repos.id, repos.owner.getId(), repos.owner.getName());
                        }
                    }
                } else {
                    try {
                        assert response.errorBody() != null;
                        Log.e("ici",response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(
                            requireActivity(),
                            "",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Repos>> call, @NonNull Throwable t) {
                Toast.makeText(requireActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private void initComponent(View view){
        matriculeText = view.findViewById(R.id.matriculeText);
        nameText = view.findViewById(R.id.nameText);
        workList = view.findViewById(R.id.allWorkList);
    }

    private void show(WorkDAO workDAO, UserDAO userDAO, int userId){
        List<Work> work = workDAO.readAll(userId);
        User user = userDAO.readOne(userId);
        StringBuilder str = new StringBuilder();
        nameText.setText(str.append(user.getName()));
        matriculeText.setText(str.append(user.getId()));

//        workList.setText(str);
        for (Work e: work) {
            workList.setText(
                    str.append(e.getId())
                            .append(" ")
                            .append(e.getDescription())
                            .append("\n")
            );
        }
    }
}