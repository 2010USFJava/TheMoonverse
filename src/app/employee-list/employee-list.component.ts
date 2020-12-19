import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import {Observable} from 'rxjs';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees:Observable<Employee[]>;

  constructor(private EmployeeService:EmployeeService,private router:Router) { }

  ngOnInit(): void {
  }

  reloadData(){
    this.employees=this.EmployeeService.getEmployeesList();
  }

  deleteEmployee(id: number) {
    this.EmployeeService.deleteEmployee(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

employeeDetails(id:number){
  this.router.navigate(['details',id]);
}

}
