import express from 'express';
import routes from './src/routes/crmRoutes'

const app = express();
const PORT = 3000;

routes(app);

app.get('/', (req, res) =>
    res.send(`node and express is running smoothly`)
);

app.listen(PORT, () =>
    console.log(`YOUR SERVER IS WORKING on ${PORT}`)
);