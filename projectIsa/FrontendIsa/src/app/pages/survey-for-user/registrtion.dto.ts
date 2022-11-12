export class RegistrationDTO{
    Name: string;
    Surname: string;
    Email: string;
    Password: string;
    CheckPassword: string;
    PhoneNumber: string;
    Jmbg: string;
    Gender: string;
    Role: number;
    Street: string;
    HouseNumber: number;
    City: string;
    State: string;
    Postcode: string;
    Education: string;
    Profession: string;

    constructor(){
        this.Name = "",
        this.Surname = "",
        this.Email = "",
        this.Password = "",
        this.CheckPassword = "",
        this.PhoneNumber = "",
        this.Jmbg = "",
        this.Gender = "",
        this.Role = 0,
        this.Street = "",
        this.HouseNumber = 0,
        this.City = "",
        this.State = "",
        this.Postcode = "",
        this.Education = "",
        this.Profession = "";
    }
}