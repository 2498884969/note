package a.txxml.service.serviceImpl;

import a.txxml.BookShopDao;
import a.txxml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao;

    public BookShopDao getBookShopDao() {
        return bookShopDao;
    }

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    /**
     * 1）.使用propagation指定事务的传播行为，即当前方法被另外一个方法调用时，如何使用事务
     * 默认值为REQUIRED，即使用调用方法的事务
     * REQUIRES_NEW使用的自己的事务，将外层事务挂起
     * 2).使用isolation指定事务的隔离级别，最常用的为READ_COMMITTED
     * 3>.默认情况Spring的声明式事务会对于所有的运行时异常进行回滚，
     * 也可以通过对应的属性进行设置,通常情况下取默认值即可
     * 4）.使用readOnly指定事务是否为只读取，但不会更新事务，这样可以帮助数据库引擎优化事务。
     * 若真的是一个只读取数据库的方法应设置readOnly = false
     * 5).使用timeout指定强制回滚之前事务可以占用的时间
     * @param username
     * @param isbn
     */

    @Override
    public void perchase(String username, String isbn) {

//        try {
//            Thread.sleep(5000);
//        }catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //  1>.获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        //  2>.更新书的库存
        bookShopDao.updateBookStock(isbn);
        //  3>.更新用户的余额
        bookShopDao.updateUserAccount(username, price);

    }
}
