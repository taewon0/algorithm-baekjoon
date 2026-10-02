-- 코드를 입력하세요

SELECT YEAR(SALES_DATE), MONTH(SALES_DATE), COUNT(DISTINCT USER_ID), ROUND(COUNT(DISTINCT USER_ID) / (
                                                    SELECT COUNT(*)
                                                    FROM USER_INFO
                                                    WHERE YEAR(JOINED) = '2021'
                                                ), 1) AS PUCHASED_RATIO
FROM ONLINE_SALE
WHERE USER_ID IN (
    SELECT USER_ID
    FROM USER_INFO
    WHERE YEAR(JOINED) = '2021'
)
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE)
ORDER BY YEAR(SALES_DATE), MONTH(SALES_DATE)


# SELECT  USER_ID
# FROM USER_INFO
# WHERE YEAR(JOINED) = '2021'