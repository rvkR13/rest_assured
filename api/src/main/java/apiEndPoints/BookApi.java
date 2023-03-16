package apiEndPoints;

import utils.ResponseWrapper;
import utils.spec.GET;

public interface BookApi {
    @GET(endpoint ="booking/{bookId}")
    ResponseWrapper getBook(String bookId);
}
