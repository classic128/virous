package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonPool {
    private static PersonPool personPool = new PersonPool();

    public static PersonPool getInstance() {
        return personPool;
    }

    List<Person> personList = new ArrayList<Person>();

    public List<Person> getPersonList() {
        return personList;
    }


    /**
     * @param state 市民类型 Person.State的值，若为-1则返回当前总数目
     * @return 获取指定人群数量
     */
    public int getPeopleSize(int state) {
        if (state == -1) {
            return personList.size();
        }
        int i = 0;
        for (Person person : personList) {
            if (person.getState() == state) {
                i++;
            }
        }
        return i;
    }


    private PersonPool() {
        City city = new City(400, 400);//设置城市中心为坐标(400,400)
        //添加城市居民
        for (int i = 0; i < Constants.CITY_PERSON_SIZE; i++) {
            Random random = new Random();
            //产生N(a,b)的数：Math.sqrt(b)*random.nextGaussian()+a
            int x = (int) (100 * random.nextGaussian() + city.getCenterX());
            int y = (int) (100 * random.nextGaussian() + city.getCenterY());
            if (x > 700) {
                x = 700;
            }
            personList.add(new Person(city, x, y));
        }


    }

    public void enterperson(){
        Random random = new Random();
        int all = (int) random.nextGaussian() + 40;
        City enter = new City(300, 300);
        if (all >= 0){
            int change = all + Constants.CITY_PERSON_SIZE;
            for (int i = 0; i <= all; i++){

                int x = (int) (100 * random.nextGaussian() + enter.getCenterX());
                int y = (int) (100 * random.nextGaussian() + enter.getCenterY());

                if (x > 700) {
                    x = 700;
                }
                personList.add(new Person(enter, x, y));

            }
        }
    }
}
