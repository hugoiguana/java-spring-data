drop function if exists test.func_products_view;
CREATE FUNCTION test.func_products_view(var_category_id varchar, var_order_by_column varchar, var_order_by varchar) RETURNS setof test.products_categories_view
AS $$
DECLARE
    var_condition_by_category_id varchar = '';
    var_order_by_clause varchar = ' ORDER BY p.id';
begin

    IF var_category_id IS NOT NULL THEN
        var_condition_by_category_id = ' AND c.id = '|| quote_literal(var_category_id);
    END IF;

    IF var_order_by_column IS NOT NULL THEN
        var_order_by_clause = ' ORDER BY '||var_order_by_column||' '||var_order_by;
    END IF;


    return query EXECUTE 'SELECT p.id, p.name, p.description, c.id AS category_id, c.name AS category_name'
                             || ' FROM test.product p'
                             || ' JOIN test.category c ON c.id = p.id_category'
                             || ' WHERE 1 = 1'
                             || var_condition_by_category_id
        || var_order_by_clause
    ;

END;
$$ LANGUAGE plpgsql;