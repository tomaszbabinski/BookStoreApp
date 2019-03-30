package pl.coderslab.spring01hibernate.repository;

import java.math.BigDecimal;

public interface BookRepositoryCustom {

    void resetRating(BigDecimal rating);
}
