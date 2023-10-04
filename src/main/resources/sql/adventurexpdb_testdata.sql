INSERT INTO Activity (name, image, description, minAge)
VALUES
    ('Gokart', 'https://images.unsplash.com/photo-1640084347692-e8f6b84caa7c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2071&q=80', 'Spændende gokart-oplevelse på vores bane.', 12),
    ('Minigolf', 'https://plus.unsplash.com/premium_photo-1661353251657-623ef3d56af0?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2069&q=80', 'Sjov minigolfaktivitet for hele familien.', 6),
    ('Paintball', 'https://images.unsplash.com/photo-1549389594-232f692594d4?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80', 'Adrenalinpumpende paintball-spil i skoven.', 16),
    ('Sumo Wrestling', 'https://images.unsplash.com/photo-1574908445051-d9e0c2f4f763?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80', 'Kæmpe som en sumobryder og se, hvem der er den stærkeste.', 18);

INSERT INTO Equipment (name, amount, activityId)
VALUES
    ('Gokart-køretøj', 10, 1),
    ('Minigolf-køller', 20, 2),
    ('Paintball-marker', 30, 3),
    ('Sumo-drakter', 8, 4);

INSERT INTO Booking (name, participants, email, phoneNumber, date, time, comment, activityId)
VALUES
    ('John Doe', 4, 'john@example.com', 71829382, '2023-10-10', '14:00:00', 'Vi vil gerne konkurrere!', 1),
    ('Alice Smith', 2, 'alice@example.com', 50281929, '2023-10-12', '16:30:00', 'Vi er en lille gruppe.', 2);

INSERT INTO Employee (name, email, password)
VALUES
    ('Mikkel Jensen', 'mikkel@example.com', 'password123'),
    ('Sara Nielsen', 'sara@example.com', 'securepass456');
