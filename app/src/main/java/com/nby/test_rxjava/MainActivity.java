package com.nby.test_rxjava;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.nby.test_rxjava.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;


public class MainActivity extends BaseActivity {
    List<Fruit> fruits = new ArrayList<>();
    @BindView(R.id.rv_main)
    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFruit();
//        rvMain = (RecyclerView) findViewById(R.id.rv_main);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvMain.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruits,MainActivity.this);
        rvMain.setAdapter(adapter);
        Observer<String> observer = new Observer<String>() {

            @Override
            public void onCompleted() {
                Log.e("onCompleted","onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e("onnext",s);
            }
        };
//        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Hello");
//                subscriber.onNext("Hi");
//                subscriber.onNext("Aloha");
//                subscriber.onCompleted();
//            }
//        });
//        Observable observable=Observable.just("你","好","姑","娘");
        String[] words = {"Hello", "Hi", "Aloha"};
        Observable observable = Observable.from(words);
        observable.subscribe(observer);

    }

    private void initFruit() {
        for (int i = 0; i < 2; i++) {
            Fruit fruit1 = new Fruit(R.mipmap.ic_launcher, "测试sdf" + 122);
            Fruit fruit2 = new Fruit(R.mipmap.ic_launcher, "测试ds" + 222222222);
            Fruit fruit3 = new Fruit(R.mipmap.ic_launcher, "测试fds测试fdsafdagdadsafvafdasfc测试fdsafdagdadsafvafdasfc" + 3332343);
            Fruit fruit4 = new Fruit(R.mipmap.ic_launcher, "测试" + 4432432);
            Fruit fruit5 = new Fruit(R.mipmap.ic_launcher, "测试fdsafdagdadsafvafdasfc测试fdsafdagdadsafvafdasfc");
            Fruit fruit6 = new Fruit(R.mipmap.ic_launcher, "测试fsafdasfd" + 625435);
            Fruit fruit7 = new Fruit(R.mipmap.ic_launcher, "测试saf" + 743543);
            Fruit fruit8 = new Fruit(R.mipmap.ic_launcher, "测试d8654365357376537测试fdsafdagdadsafvafdasfc");
            Fruit fruit9 = new Fruit(R.mipmap.ic_launcher, "测试fasf" + 9);
            Fruit fruit10 = new Fruit(R.mipmap.ic_launcher, "测试dfsf" + 10);
            fruits.add(fruit1);
            fruits.add(fruit2);
            fruits.add(fruit3);
            fruits.add(fruit4);
            fruits.add(fruit5);
            fruits.add(fruit6);
            fruits.add(fruit7);
            fruits.add(fruit8);
            fruits.add(fruit9);
            fruits.add(fruit10);
        }

    }

}
