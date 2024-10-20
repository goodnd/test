import request from '@/utils/request'

// 查询垃圾运输记录列表
export function listTransportRecord(query) {
  return request({
    url: '/system/transportRecord/list',
    method: 'get',
    params: query
  })
}

// 查询垃圾运输记录详细
export function getTransportRecord(id) {
  return request({
    url: '/system/transportRecord/' + id,
    method: 'get'
  })
}

// 新增垃圾运输记录
export function addTransportRecord(data) {
  return request({
    url: '/system/transportRecord',
    method: 'post',
    data: data
  })
}

// 修改垃圾运输记录
export function updateTransportRecord(data) {
  return request({
    url: '/system/transportRecord',
    method: 'put',
    data: data
  })
}

// 删除垃圾运输记录
export function delTransportRecord(id) {
  return request({
    url: '/system/transportRecord/' + id,
    method: 'delete'
  })
}
