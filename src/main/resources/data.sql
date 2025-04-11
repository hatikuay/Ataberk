-- CATEGORY INSERTS
INSERT INTO category (id,name) VALUES (1,'Roman') ON CONFLICT (id) DO NOTHING;
INSERT INTO category (id,name) VALUES (2,'Bilim') ON CONFLICT (id) DO NOTHING;
INSERT INTO category (id,name) VALUES (3,'Tarih') ON CONFLICT (id) DO NOTHING;

-- BOOK INSERTS with explicit IDs
INSERT INTO book (id, title, author, category_id) VALUES (1, 'Sefiller', 'Victor Hugo', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author, category_id) VALUES (2, 'Zamanın Kısa Tarihi', 'Stephen Hawking', 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author, category_id) VALUES (3, 'Nutuk', 'Mustafa Kemal Atatürk', 3) ON CONFLICT (id) DO NOTHING;
