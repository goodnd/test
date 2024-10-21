import request from '@/utils/request'

// 查询回收站点人员列表
export function listStationPeople(query) {
  return request({
    url: '/system/stationPeople/list',
    method: 'get',
    params: query
  })
}

// 查询回收站点人员详细
export function getStationPeople(id) {
  return request({
    url: '/system/stationPeople/' + id,
    method: 'get'
  })
}

// 新增回收站点人员
export function addStationPeople(data) {
  return request({
    url: '/system/stationPeople',
    method: 'post',
    data: data
  })
}

// 修改回收站点人员
export function updateStationPeople(data) {
  return request({
    url: '/system/stationPeople',
    method: 'put',
    data: data
  })
}

// 删除回收站点人员
export function delStationPeople(id) {
  return request({
    url: '/system/stationPeople/' + id,
    method: 'delete'
  })
}
