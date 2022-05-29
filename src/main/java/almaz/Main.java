package almaz;

import almaz.dao.PersonDao;

public class Main {
    public static void main(String[] args) throws Exception {
        PersonDao personDao = new PersonDao();
//        personDao.save(new Person("Dilbara",19,"dilbara2025@gmaiL.com"));
//        personDao.save(new Person("Muhammed",25,"muhammed@gmaiL.com"));
//        personDao.save(new Person("Elnura",23,"elnura@gmaiL.com"));
//        personDao.save(new Person("Almaz F",20,"almaz@gmaiL.com"))
//        personDao.deleteById(1L);
//        System.out.println(personDao.findById(3L));
        personDao.findAll().forEach(System.out::println);
//        personDao.deleteById(1L);
          personDao.close();
    }
}
