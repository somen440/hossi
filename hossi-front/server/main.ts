import express, { Request, Response } from 'express';
import register from '@react-ssr/express/register';
import { config, toMaskConfig } from './config/config';

const app = express();

(async () => {
  await register(app);

  app.get('/', (_req: Request, res: Response) => {
    const user = { name: 'World' };
    res.render('index', { user });
  });

  app.listen(config.port, () => {
    console.log(`${toMaskConfig(config)}`);
    console.log(`> Ready on http://localhost:${config.port}`);
  });
})();
