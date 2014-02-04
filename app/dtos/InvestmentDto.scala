package dtos

case class InvestmentDto (
    name: String, 
    investor: String, 
    buyIn: Float, 
    fee: Float, 
    value: Float, 
    currency: String, 
    rate: Float, 
    netRate: Float
)
