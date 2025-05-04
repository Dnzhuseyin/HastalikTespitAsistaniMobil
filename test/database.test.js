const mongoose = require('mongoose');
const dotenv = require('dotenv');

dotenv.config();

describe('Database Connection', () => {
  beforeAll(async () => {
    await mongoose.connect(process.env.MONGODB_URI);
  });

  afterAll(async () => {
    await mongoose.connection.close();
  });

  it('should connect to MongoDB', () => {
    const connectionState = mongoose.connection.readyState;
    expect(connectionState).toBe(1); // 1 = connected
  });
}); 