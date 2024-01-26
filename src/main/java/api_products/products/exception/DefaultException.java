package api_products.products.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultException {

    private int status;
    private String message;

}
