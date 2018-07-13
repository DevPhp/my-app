import { Pipe, PipeTransform } from '@angular/core';
import {AdminService} from "./services/admin.Service";
import { concat } from 'rxjs/operators/concat';

@Pipe({
  name: 'filterAgent',
  pure: false
})

     export class filterAgent implements PipeTransform {  
     
      constructor(
        private adminService: AdminService
        ) { }

      
        
    
      transform(items: any[], searchAgent: String): any {
          if (!items || !searchAgent) {
              return items;
          }
          searchAgent = searchAgent.toLowerCase();
          return items.filter(item => item.assignedAgent.toLowerCase().indexOf(searchAgent) !== -1);
      }
  }

  
@Pipe({
  name: 'filterState',
  pure: false
})

     export class filterState implements PipeTransform {  
     
      constructor(
        private adminService: AdminService
        ) { }

      
      transform(items: any[], searchState: String): any {
          if (!items || !searchState) {
              return items;
          }

          searchState = searchState.toLowerCase();
          return items.filter(item => item.state.toLowerCase().indexOf(searchState) !== -1);          
      }
  }


  @Pipe({
    name: 'filterCounty',
    pure: false
  })
  
       export class filterCounty implements PipeTransform {  
       
        constructor(
          private adminService: AdminService
          ) { }
  
        
        transform(items: any[], searchCounty: String): any {
            if (!items || !searchCounty) {
                return items;
            }        
            searchCounty = searchCounty.toLowerCase();
            return items.filter(item => item.county.toLowerCase().indexOf(searchCounty) !== -1); 
            
        }
    }
  
    @Pipe({
      name: 'filterZipCode',
      pure: false
    })
    
         export class filterZipCode implements PipeTransform {  
         
          constructor(
            private adminService: AdminService
            ) { }
    
          
          transform(items: any[], searchZipCode: String): any {
              if (!items || !searchZipCode) {
                  return items;
              }        
             // searchZipCode = searchZipCode.toLowerCase();
              return items.filter(item => item.zipcode.toString().indexOf(searchZipCode) !== -1); 
              
          }
      }

      @Pipe({
        name: 'filterInvoice',
        pure: false
      })
      
           export class filterInvoice implements PipeTransform {  
           
            constructor(
              private adminService: AdminService
              ) { }
      
            
            transform(items: any[], searchInvoice: number): any {
                if (!items || !searchInvoice) {
                  
                    return items;
                }        
                //searchInvoice = searchInvoice.toLowerCase();
                return items.filter(item => item.invoiceNo.toString().indexOf(searchInvoice) !== -1); 
                
            }
        }

        @Pipe({
          name: 'filterProductCode',
          pure: false
        })
        
             export class filterProductCode implements PipeTransform {  
             
              constructor(
                private adminService: AdminService
                ) { }
        
              
              transform(items: any[], searchProductCode: string): any {
                  if (!items || !searchProductCode) {
                    
                      return items;
                  }        
                  searchProductCode = searchProductCode.toLowerCase();
                  return items.filter(item => item.productCode.toLowerCase().indexOf(searchProductCode) !== -1); 
                  
              }
          }

          @Pipe({
            name: 'filterUndispositionedLeads',
            pure: false
          })
          
               export class filterUndispositionedLeads implements PipeTransform {  
               
                constructor(
                  private adminService: AdminService
                  ) { }
          
                
                transform(items: any[], searchUndispositionedLeads: string): any {
                    if (!items || !searchUndispositionedLeads) {
                      
                        return items;
                    }        
                    //searchUndispositionedLeads = searchUndispositionedLeads.toLowerCase();
                    return items.filter(item => item.wo_dispostion.toString().indexOf(searchUndispositionedLeads) !== -1); 
                    
                }
            }

            @Pipe({
                name: 'filterUserName',
                pure: false
              })
              
                   export class filterUserName implements PipeTransform {  
                   
                    constructor(
                      private adminService: AdminService
                      ) { }
              
                    
                    transform(items: any[], searchUserName: string): any {
                        //console.log(items);
                        if (!items || !searchUserName) {   
                            return items;
                            
                        }        
                        searchUserName = searchUserName.toLowerCase();
                        
                        return items.filter(item => item.eacID.toLowerCase().indexOf(searchUserName) !== -1); 
                        
                    }
                    
                }

            @Pipe({
                name: 'filterNpn',
                pure: false
              })
              
                   export class filterNpn implements PipeTransform {  
                   
                    constructor(
                      private adminService: AdminService
                      ) { }
              
                    
                      transform(items: any[], searchNpn: string): any {
                        if (!items || !searchNpn) {   
                            return items;
                        }        
                        searchNpn = searchNpn.toLowerCase();
                        return items.filter(item => item.npn.toLowerCase().indexOf(searchNpn) !== -1); 
                        
                    }
                }

            @Pipe({
                name: 'filterReceivedDateRange',
                pure: false
              })
              
                   export class filterReceivedDateRange implements PipeTransform {  
                   
                    constructor(
                      private adminService: AdminService
                      ) { }
              
                    
                    transform(items: any[], searchReceivedDateRange: string): any {
                        if (!items || !searchReceivedDateRange) {
                          
                            return items;
                        }        
                        //searchReceivedDateRange = searchReceivedDateRange.toLowerCase();
                        return items.filter(item => item.receivedDate.indexOf(searchReceivedDateRange) !== -1); 
                        
                    }
                }