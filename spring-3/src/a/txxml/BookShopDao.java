package a.txxml;


public interface BookShopDao {

    //  1>.根据书号获取书的单价
    public int findBookPriceByIsbn(String isbn);
    //  2>.更新书的库存，使得对应的库存 -1
    public void updateBookStock(String isbn);
    //  3>.更新用户的账户余额：使username 的balance - price
    public void updateUserAccount(String username, int price);

}
