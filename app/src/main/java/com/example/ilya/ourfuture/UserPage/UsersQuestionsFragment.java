package com.example.ilya.ourfuture.UserPage;

import android.os.Bundle;

import com.example.ilya.ourfuture.Markers.MarkersQuestionsPresenter;
import com.example.ilya.ourfuture.Shared.Id;
import com.example.ilya.ourfuture.Question.QuestionsListFragment;

public class UsersQuestionsFragment extends QuestionsListFragment /*QuestionsListFragment implements IPostsView*/ {

    //IPostsPresenter postsPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        int userId = args.getInt("userId", Id.getId());

        questionsListPresenter = new UsersQuestionsPresenter(userId, this);

        ((UsersQuestionsPresenter)questionsListPresenter).receiveQuestions(1);
    }

    public void questionsTypeChanged(int type) { //as well will be executed authomatically from the header
        ((UsersQuestionsPresenter)questionsListPresenter).receiveQuestions(type);
        System.out.println(type);
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, null);

        Bundle args = getArguments();

        int userId = args.getInt("userId", Id.getId());

        questionsListPresenter = new UsersQuestionsPresenter(userId, this);

        questionsListPresenter.receiveQuestions(userId);
        //QuestionsList.getQuestions(id, userId);

        return view;
    }*/

    /*@Override
    public void onResume() {
        super.onResume();

        Bundle args = getArguments();

        int userId = args.getInt("userId", Id.getId());

        questionsListPresenter = new UsersQuestionsPresenter(userId, this);

        questionsListPresenter.receiveQuestions(userId);
    }*/

    /*@Override
    public void representPosts(ArrayList<Question> questions) {
        //QuestionsAdapter adapter = new QuestionsAdapter(getActivity(), R.layout.fragment_post, R.layout.fragment_post, questions, questionsListPresenter);
        //setListAdapter(adapter);
    }*/

    /*@Override
    public void openQuestion(int id, int position, ArrayList<Question> questions) {
        Intent intent = new Intent(this.getActivity(), QuestionActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("position", position);
        intent.putExtra("questions", questions);
        startActivity(intent);
    }*/
}

