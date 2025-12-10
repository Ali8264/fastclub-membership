-- Insert Tiers
INSERT INTO tier (id, name, discount_percent, free_delivery, priority_support)
VALUES ('1', 'SILVER', 5, TRUE, FALSE);

INSERT INTO tier (id, name, discount_percent, free_delivery, priority_support)
VALUES ('2', 'GOLD', 10, TRUE, TRUE);

INSERT INTO tier (id, name, discount_percent, free_delivery, priority_support)
VALUES ('3', 'PLATINUM', 20, TRUE, TRUE);

-- Insert Plans
INSERT INTO plan (id, name, billing_cycle, price)
VALUES ('p-monthly', 'Monthly', 'MONTHLY', 199.00);

INSERT INTO plan (id, name, billing_cycle, price)
VALUES ('p-quarterly', 'Quarterly', 'QUARTERLY', 549.00);

INSERT INTO plan (id, name, billing_cycle, price)
VALUES ('p-yearly', 'Yearly', 'YEARLY', 1999.00);
