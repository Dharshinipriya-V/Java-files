const vehicles = [
    
        {
          "id": 1,
          "name": "Streak",
          "date": "2024-01-07",
          "district": "Salem",
          "registrationnumber": "MH12 AB 1234",
          "milage": 49490
        },
        {
          "id": 2,
          "name": "Splendor",
          "date": "2023-05-08",
          "district": "Chennai",
          "registrationnumber": "DL05 CD 5678",
          "milage": 74046
        },
        {
          "id": 3,
          "name": "Honda",
          "date": "2021-06-09",
          "district": "Coimbatore",
          "registrationnumber": "KA01 EF 9012",
          "milage": 64900
        },
        {
          "id": 4,
          "name": "Jawa",
          "date": "2024-02-23",
          "district": "Erode",
          "registrationnumber": "TN10 GH 3456",
          "milage": 198000
        },
        {
          "id": 5,
          "name": "Royal Enfield",
          "date": "2021-06-07",
          "district": "Madurai",
          "registrationnumber": "RJ14 IJ 7890",
          "milage": 165000
        },
        {
          "id": 6,
          "name": "Jupiter",
          "date": "2023-08-04",
          "district": "Vellore",
          "registrationnumber": "UP32 KL 2345",
          "milage": 140000
        },
        {
          "id": 7,
          "name": "Pulsar",
          "date": "2024-03-15",
          "district": "Chennai",
          "registrationnumber": "DL05 CD 5678",
          "milage": 85000
        },
        {
          "id": 8,
          "name": "Activa",
          "date": "2024-02-20",
          "district": "Mumbai",
          "registrationnumber": "KA01 EF 9012",
          "milage": 74500
        },
        {
          "id": 9,
          "name": "Splendor",
          "date": "2024-05-12",
          "district": "Coimbatore",
          "registrationnumber": "TN10 GH 3456",
          "milage": 62300
        },
        {
          "id": 10,
          "name": "Apache",
          "date": "2024-04-08",
          "district": "Jaipur",
          "registrationnumber": "RJ14 IJ 7890",
          "milage": 90000
        },
        {
          "id": 11,
          "name": "Jupiter",
          "date": "2024-06-22",
          "district": "Lucknow",
          "registrationnumber": "UP32 KL 2345",
          "milage": 70700
        },
        {
          "id": 12,
          "name": "Access",
          "date": "2024-07-19",
          "district": "Kolkata",
          "registrationnumber": "WB06 MN 6789",
          "milage": 65400
        },
        {
          "id": 13,
          "name": "Dio",
          "date": "2024-03-10",
          "district": "Ahmedabad",
          "registrationnumber": "GJ03 OP 1122",
          "milage": 55800
        },
        {
          "id": 14,
          "name": "FZ",
          "date": "2023-09-23",
          "district": "Varkala",
          "registrationnumber": "Va09 UI 9078",
          "milage": 123000
        },
        {
          "id": 15,
          "name": "Honda-activa",
          "date": "2009-08-08",
          "district": "Mumbai",
          "registrationnumber": "JDJH YG 6754",
          "milage": 120000
        }
      
  ];
  
  // 1. Group the data by vehicles whose names start with "H," have a price range of 70,000 to 1,20,000 INR, and are registered in Mumbai with a mileage above 60 km.
  const filteredAndGroupedVehicles = vehicles
    .filter(vehicle => vehicle.name.startsWith('H'))
    .filter(vehicle => vehicle.district === 'Mumbai')
    .filter(vehicle => vehicle.milage > 60000)
    .reduce((grouped, vehicle) => {
      const key = vehicle.name;
      if (!grouped[key]) {
        grouped[key] = [];
      }
      grouped[key].push(vehicle);
      return grouped;
    }, {});
  
  console.log("Grouped vehicles:");
  console.log(filteredAndGroupedVehicles);
  
  // 2. Filter vehicles that start with the letter 'S'
  const vehiclesStartingWithS = vehicles.filter(v => v.name.startsWith('S'));
  console.log("Vehicles starting with 'S':", vehiclesStartingWithS);
  
  // 3. Filter vehicles with a price above 1 lakh (assuming `price` field exists)
  const vehiclesAbove1Lakh = vehicles.filter(v => v.milage > 100000);  // Adjusted as `price` is not provided
  console.log('Vehicles with mileage above 1 lakh:', vehiclesAbove1Lakh);
  
  // 4. Filter vehicles registered in Coimbatore with price range 50000-90000 and mileage above 50 (assuming price data)
  const filteredVehicles1 = vehicles.filter(v => 
      v.district === 'Coimbatore' && v.milage >= 50000 && v.milage <= 90000
  );
  console.log('Vehicles registered in Coimbatore with mileage between 50000-90000:', filteredVehicles1);
  
  // 5. Filter vehicles starting with 'H', registered in Mumbai, with mileage > 60
  const vehiclesStartingWithH = vehicles.filter(v => 
      v.name.startsWith('H') && v.district === 'Mumbai' && v.milage > 60000
  );
  console.log("Vehicles starting with 'H', registered in Mumbai:", vehiclesStartingWithH);
  