FROM node:14.16.1-alpine3.10 as node-build

WORKDIR /app

COPY . .

RUN yarn
RUN yarn build

CMD [ "yarn", "start" ]
