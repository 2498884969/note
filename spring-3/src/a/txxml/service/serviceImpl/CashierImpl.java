package a.txxml.service.serviceImpl;

import a.txxml.service.BookShopService;
import a.txxml.service.Cashier;

import java.util.List;

public class CashierImpl implements Cashier {

    private BookShopService bookShopService;

    public BookShopService getBookShopService() {
        return bookShopService;
    }

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    /**使用propagation属性指定事务的传播行为
     *
     * @param username
     * @param isbns
     */
    @Override
    public void checkout(String username, List<String> isbns) {
        for(String isbn:isbns){
            bookShopService.perchase(username,isbn);
        }
    }
}
