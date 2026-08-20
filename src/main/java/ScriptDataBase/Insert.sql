
INSERT INTO "User" (id, ref, "firstName", "lastName", email, phone) VALUES
                                                                        ('u1', 'REF-U001', 'Rado',   'Andria',  'rado.andria@mail.mg',   '0341234567'),
                                                                        ('u2', 'REF-U002', 'Nirina', 'Rakoto',  'nirina.rakoto@mail.mg', '0331234567'),
                                                                        ('u3', 'REF-U003', 'Hery',   'Randria', 'hery.randria@mail.mg',  '0321234567');

INSERT INTO "CashFlow" (id, "createdAt", amount, user_id) VALUES
                                                              ('cf1', '2026-01-10 09:00:00', 50000.00,  'u1'),
                                                              ('cf2', '2026-02-15 14:30:00', 120000.00, 'u2'),
                                                              ('cf3', '2026-03-05 18:45:00', 25000.00,  'u3'),
                                                              ('cf4', '2026-04-01 10:00:00', 15000.00,  'u1'),
                                                              ('cf5', '2026-04-10 11:20:00', 8000.00,   'u2'),
                                                              ('cf6', '2026-04-20 16:00:00', 30000.00,  'u3');

INSERT INTO "Donation" (id, comment) VALUES
                                         ('cf1', 'Don pour la construction de l ecole'),
                                         ('cf2', 'Don en soutien aux sinistres'),
                                         ('cf3', 'Don anonyme');


INSERT INTO "Expense" (id, reason, frequency) VALUES
                                                  ('cf4', 'Achat de fournitures', 'MONTHLY'),
                                                  ('cf5', 'Frais de transport',   'WEEKLY'),
                                                  ('cf6', 'Entretien du local',   'YEARLY');