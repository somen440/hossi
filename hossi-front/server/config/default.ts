export interface CommonConfig {
  port: string
}

export const commonConfig: CommonConfig = {
  port: process.env.PORT || "3000"
}
