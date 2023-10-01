const moment = require('moment');

const currentDate = moment();

const futureDate = currentDate.add(5,'days');

console.log('Current Date: ', currentDate.format('YYYY-MM-DD'));
console.log('Date after adding 5 days: ', futureDate.format('YYYY-MM-DD'));