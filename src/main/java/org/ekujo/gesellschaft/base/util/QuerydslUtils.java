package org.ekujo.gesellschaft.base.util;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.domain.QPersona;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class QuerydslUtils {
    public static OrderSpecifier<?>[] convertSortToOrderSpecifier(Sort sort, QPersona persona) {
        List<OrderSpecifier<?>> orders = new ArrayList<>();

        for (Sort.Order order : sort) {
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
            switch (order.getProperty()) {
                case "name":
                    orders.add(new OrderSpecifier<>(direction, persona.name));
                    break;
                case "id":
                    orders.add(new OrderSpecifier<>(direction, persona.id));
                    break;
                case "characterId":
                    orders.add(new OrderSpecifier<>(direction, persona.character.id));
                    break;
                default:
                    throw new IllegalArgumentException("지원하지 않는 정렬 필드: " + order.getProperty());
            }
        }

        return orders.toArray(new OrderSpecifier[0]);
    }
}

